package com.springmongodbademely.repository;

import java.util.List;

import com.springmongodbademely.enums.TransactionTypeGroup;

public class OperationsRepository {
	
	public List<Integer> getIdsMerchantMonthlyFee() {
        List<Integer> idTypes = TransactionTypeGroup.TRANSACTIONS_FEES_PAYMENTS_REFUNDS.getIdsTransactionTypes();
        return  idTypes;
    }
	
	public List<Integer> getIdsAdjustments() {
        List<Integer> idTypes = TransactionTypeGroup.TRANSACTIONS_ADJUSTMENTS_REFUND.getIdsTransactionTypes();
        return  idTypes;
    }

}
