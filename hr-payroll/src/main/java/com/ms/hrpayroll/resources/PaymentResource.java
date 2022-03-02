package com.ms.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.hrpayroll.entities.Payment;
import com.ms.hrpayroll.services.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable("workerId") Long workerId, @PathVariable("days") Integer days) {
		Payment payment = this.paymentService.getPayment(workerId, days);
		
		return ResponseEntity.ok(payment);
	}
}
