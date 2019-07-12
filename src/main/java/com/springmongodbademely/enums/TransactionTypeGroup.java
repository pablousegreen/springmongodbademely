package com.springmongodbademely.enums;

import java.util.ArrayList;
import java.util.List;


public enum TransactionTypeGroup {
    TRANSACTIONS_IN(getIdsTrxTypesForPayoutIN()),
    TRANSACTIONS_OUT(getIdsTrxTypesForPayoutOUT()),
    TRANSACTIONS_ADJUSTMENTS_PAYMENT(getIdsTrxTypesForPayoutAdjustmentsPayment()),
    TRANSACTIONS_ADJUSTMENTS_REFUND(getIdsTrxTypesForPayoutAdjustmentsRefund()),
    TRANSACTIONS_FEES_PAYMENTS_REFUNDS(getOpenpayFeesTransactionsTypes());

    private List<Integer> idsTransactionTypes;

    private TransactionTypeGroup(final List<Integer> idsTransactionTypes) {
        this.idsTransactionTypes = idsTransactionTypes;
    }

    public List<Integer> getIdsTransactionTypes() {
        return new ArrayList<>(this.idsTransactionTypes);
    }

    private static List<Integer> getIdsTrxTypesForPayoutIN() {
        List<Integer> requieredIds = new ArrayList<>();
        requieredIds.add(TransactionType.SPEI.getIdTransactionType());
        requieredIds.add(TransactionType.BANK_TRANSFER_CHARGE.getIdTransactionType());
        requieredIds.add(TransactionType.CARD_DEBIT.getIdTransactionType());
        requieredIds.add(TransactionType.PAYNET_CHARGE.getIdTransactionType());
        requieredIds.add(TransactionType.PAYNET_DEPOSIT.getIdTransactionType());
        requieredIds.add(TransactionType.FEE_REFUND.getIdTransactionType());
        requieredIds.add(TransactionType.FEE_TAX_REFUND.getIdTransactionType());
        requieredIds.add(TransactionType.ABONAHORRO_CHARGE.getIdTransactionType());
        requieredIds.add(TransactionType.CHARGEBACK_ADJUSTMENT.getIdTransactionType());
        requieredIds.add(TransactionType.BITCOIN_CHARGE.getIdTransactionType());
        requieredIds.add(TransactionType.ADJUSTMENT_REFUND.getIdTransactionType());
        return requieredIds;
    }

    private static List<Integer> getIdsTrxTypesForPayoutOUT() {
        List<Integer> requieredIds = new ArrayList<>();
        requieredIds.add(TransactionType.AUTOMATIC_BANK_DEPOSIT.getIdTransactionType());
        requieredIds.add(TransactionType.CARD_DEPOSIT.getIdTransactionType());
        requieredIds.add(TransactionType.BANK_DEPOSIT.getIdTransactionType());
        requieredIds.add(TransactionType.FEE_PAYMENT.getIdTransactionType());
        requieredIds.add(TransactionType.FEE_TAX_PAYMENT.getIdTransactionType());
        requieredIds.add(TransactionType.CARD_REFUND.getIdTransactionType());
        requieredIds.add(TransactionType.CHARGEBACK.getIdTransactionType());
        requieredIds.add(TransactionType.ADJUSTMENT_CHARGE.getIdTransactionType());
        return requieredIds;
    }

    private static List<Integer> getIdsTrxTypesForPayoutAdjustmentsPayment() {
        List<Integer> requieredIds = new ArrayList<>();
        requieredIds.add(TransactionType.FEE_PAYMENT.getIdTransactionType());
        requieredIds.add(TransactionType.FEE_TAX_PAYMENT.getIdTransactionType());
        return requieredIds;
    }

    private static List<Integer> getIdsTrxTypesForPayoutAdjustmentsRefund() {
        List<Integer> requieredIds = new ArrayList<>();
        requieredIds.add(TransactionType.FEE_REFUND.getIdTransactionType());
        requieredIds.add(TransactionType.FEE_TAX_REFUND.getIdTransactionType());
        return requieredIds;
    }

    private static List<Integer> getOpenpayFeesTransactionsTypes() {
        List<Integer> idTypes = new ArrayList<>();
        idTypes.add(TransactionType.FEE_PAYMENT.getIdTransactionType());
        idTypes.add(TransactionType.FEE_TAX_PAYMENT.getIdTransactionType());
        idTypes.add(TransactionType.FEE_REFUND.getIdTransactionType());
        idTypes.add(TransactionType.FEE_TAX_REFUND.getIdTransactionType());
        return idTypes;
    }
}
