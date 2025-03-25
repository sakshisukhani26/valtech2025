package com.valtech.training.registerservice.vos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;

public record SubscriptionVO(long id,int amount,String subscriptionStart,String subscriptionEnd,List<Long> custids) {
	
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("DD-MM-YYYY");
	
	public static SubscriptionVO from(Subscription s) {
		String start = s.getSubscriptionStart().format(FORMATTER);
		String end = s.getSubscriptionEnd().format(FORMATTER);
		List<Long> ids = s.getUsers().stream().map(u -> u.getId()).collect(Collectors.toList());
		return new SubscriptionVO(s.getId(), s.getAmount(),start,end,ids);
	}
	
	public  Subscription to(List<User> u) {
		LocalDate startDate = LocalDate.parse(subscriptionStart);
		LocalDate endDate = LocalDate.parse(subscriptionEnd);
		Subscription s = new Subscription(amount,startDate,endDate);
		s.setUsers(u);
		return s;
	}

}
