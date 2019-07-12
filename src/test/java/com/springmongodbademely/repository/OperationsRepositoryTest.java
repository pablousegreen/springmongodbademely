package com.springmongodbademely.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class OperationsRepositoryTest {

	@Test
	void test() {
		OperationsRepository or = new OperationsRepository();
		Integer expct = null;
		List<Integer> resutls = or.getIdsMerchantMonthlyFee();
		resutls.stream().filter(a -> a>15).sorted().forEach(action ->{
			System.out.println(action);
		});
		assertEquals(expct, resutls);
	}

}
