package com.passion_share_track.share_track.services;

import com.passion_share_track.share_track.models.Cart;
import com.passion_share_track.share_track.models.CartItem;
import com.passion_share_track.share_track.models.Item;
import com.passion_share_track.share_track.models.User;
import com.passion_share_track.share_track.repositories.CartItemRepository;
import com.passion_share_track.share_track.repositories.CartRepository;
import com.passion_share_track.share_track.repositories.ItemRepository;
import com.passion_share_track.share_track.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
@Component
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    public Iterable<Cart> index() {
        return cartRepository.findAll();
    }

    public Cart show(Long id) {
        return cartRepository.findById(id).get();
    }

    public Cart create(Cart item) {
        return cartRepository.save(item);
    }

    public Cart update(Long id, Cart newCartData) {
        Cart originalCart = cartRepository.findById(id).get();
//        originalCart.set(newCartData.getFirstName());
//        originalCart.setLastName(newCartData.getLastName());
//        originalCart.setUserRole(newUserData.getUserRole());
//        originalCart.setLocationId(newUserData.getLocationId());
        return cartRepository.save(originalCart);
    }
    //create new cart
    public Cart createCart(User user){
        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);
    }

    // add item to cart
    public Cart addItemToCart(Long cartId, Long itemId, int quantity) {
       // check for cart exists
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new NoSuchElementException("Cart not found with ID: " + cartId));
// pull item
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new NoSuchElementException("Item not found with ID: " + itemId));

        System.out.println("cartisian" + cart);
//        Item item = itemRepository.getReferenceById(itemId);
        if (item.getCountAvailable() <= 0){
            throw new IllegalStateException("Item is out of stock.");
        }
        //Deduct one item from count
        item.setCountAvailable(item.getCountAvailable() - quantity);

        // Set item's home location to the user's location
        if (cart.getUser() != null && cart.getUser().getLocation() != null) {
            item.setHomeLocation(cart.getUser().getLocation());
        } else {
            throw new IllegalStateException("User or user's location is missing.");
        }
        System.out.println(item);
        boolean found = false;
        //updating cartItem quntity - avoiding multiple entries for same item in cart
        for (CartItem cartItem : cart.getCartItems()) {
            if (Objects.equals(cartItem.getItem().getId(), item.getId())) {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                found = true;
                break;
            }
        }

        if (!found) {
            CartItem newCartItem = new CartItem(item, quantity, cart);
            cartItemRepository.save(newCartItem);
            cart.getCartItems().add(newCartItem);
        }

        itemRepository.save(item);
        cartRepository.save(cart);

        return cartRepository.save(cart);
    }


    //get user's Cart
    public Cart getCartByUserId(Long userId) {
        System.out.println(userId);
        if (userId == null) {
            throw new IllegalArgumentException("User ID must not be null.");
        }
        Cart userCart = cartRepository.findByUser_Id(userId);
        if (userCart != null) {
            return userCart;
        }
        // Create new cart if it doesn't exist
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with ID: " + userId));

        createCart(user);

        return cartRepository.save(new Cart(user));

    }

    //list all cart Items
    public List<CartItem> getItemsInCart(Long cartId) {
//        Cart cart = cartRepository.findById(cartId)
//                .orElseThrow(() -> new RuntimeException("Cart not found"));
//        return cart.getItems();
        return null;
    }

    public Boolean delete(Long id) {
        Optional<Cart> itemOptional = cartRepository.findById(id);

        if (itemOptional.isPresent()) {
            cartRepository.deleteById(id);
            return true; // successfully deleted
        } else {
            return false; // no item found to delete
        }
    }

}
