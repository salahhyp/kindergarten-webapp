package com.daaw.project.Controllers;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@CrossOrigin(origins="http://localhost:3000")


@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    // Replace with your actual Stripe secret key
    @Value("sk_test_51PFypMH3kOr3AVMZdg6805uyE5TAiPd4xqxUJtY88SFsvgRPsqo2Q96AookUyh3k1tUAfkOg2WCpcjyKMcScN33c00cFl8xw1Y")
    private String stripeSecretKey;

    @PostMapping("/create-checkout-session")
    public ResponseEntity<?> createCheckoutSession(@RequestBody Map<String, Object> requestBody) throws StripeException {
        System.out.println("Received payment request for"+requestBody.get("priceId"));
        String YOUR_DOMAIN = "http://localhost:3000/"; // Replace with your actual domain
        String priceId = (String) requestBody.get("priceId");
        SessionCreateParams params =
                SessionCreateParams.builder()
                        .setUiMode(SessionCreateParams.UiMode.EMBEDDED)
                        .setMode(SessionCreateParams.Mode.PAYMENT)
                        // .setReturnUrl(YOUR_DOMAIN + "/return?session_id={CHECKOUT_SESSION_ID}")
                        .setRedirectOnCompletion(SessionCreateParams.RedirectOnCompletion.NEVER )
                        .addLineItem(
                                SessionCreateParams.LineItem.builder()
                                        .setQuantity(1L)
                                        // Provide the exact Price ID (for example, pr_1234) of the product you want to sell
                                        .setPrice(priceId)
                                        .build())
                        .build();

        // Initialize Stripe with your secret key
        Stripe.apiKey = stripeSecretKey;

        Session session = Session.create(params);

        Map<String, String> response = new HashMap<>();
        response.put("clientSecret", session.getClientSecret());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/session-status")
    public ResponseEntity<?> getSessionStatus(@RequestParam String sessionId) throws StripeException {
        // Initialize Stripe with your secret key
        Stripe.apiKey = stripeSecretKey;

        Session session = Session.retrieve(sessionId);

        Map<String, String> response = new HashMap<>();
        response.put("status", session.getStatus());
        response.put("customer_email", session.getCustomerDetails().getEmail());

        return ResponseEntity.ok(response);
    }
}