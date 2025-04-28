package com.passion_share_track.share_track.services;

import com.passion_share_track.share_track.models.Cart;
import com.passion_share_track.share_track.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
public class CartService {

    @Autowired
    CartRepository cartRepository;

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
