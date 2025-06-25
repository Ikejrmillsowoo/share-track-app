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
       Cart cart = cartRepository.findById(cartId)
               .orElseThrow(() -> new RuntimeException("Cart not found"));
        Item item = itemRepository.getReferenceById(itemId);
        CartItem cartItem = new CartItem(item, quantity, cart);
       cart.setCartItem(cartItem); // this sets up the bidirectional relationship
        cartRepository.save(cart);

        return cart;
    }

    //get user's Cart
    public Optional<Cart> getCartByUserId(Long userId) {
        if (userId == null) {
            throw new IllegalArgumentException("User ID must not be null.");
        }
        return cartRepository.findByUser_Id(userId);
//                .orElseThrow(() ->
//                new NoSuchElementException("No cart found for user with ID: " + userId)
//        );
//        List<Cart> allCarts = cartRepository.findAll();
//       for (Cart cart: allCarts){
//           if (Objects.equals(cart.getUser().getId(), userId)){
//               return cart;
//           };
//       }
//        return null;
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
