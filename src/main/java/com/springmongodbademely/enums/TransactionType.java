package com.springmongodbademely.enums;

import java.util.ArrayList;
import java.util.List;



/*
 * NOTA: Este enum es un volcado de la tabla de Transactions_types.
 */
public enum TransactionType {

    // INPUTS

    /** Cuando se fondea la cuenta del merchant por SPEI (1) */
    SPEI(1, "SPEI recibidos", TransactionTypeOperation.IN, Category.CHARGE, Method.BANK_ACCOUNT),

    /** Cargo a tarjeta para agregar a account. (3) */
    CARD_DEBIT(3, "Cargos a tarjeta", TransactionTypeOperation.IN, Category.CHARGE, Method.CARD),

    /** Transaccion del account destino en un traspaso entre accounts. (7) */
    TRANSFER_TO(7, "Transfer to", TransactionTypeOperation.IN, Category.TRANSFER, Method.CUSTOMER),

    /** Transaccion del account al que se le esta depositando el cobro de una comision. (9) */
    FEE_TO(9, "Fee to", TransactionTypeOperation.IN, Category.FEE, Method.CUSTOMER),

    /** Cargo al cliente mediante transferencia interbancaria con referencia. (15) */
    BANK_TRANSFER_CHARGE(15, "Bank Transfer Charge", TransactionTypeOperation.IN, Category.CHARGE, Method.BANK_ACCOUNT),

    /** Cargo a pagar en una tienda de conveniencia mediante Paynet (16) */
    PAYNET_CHARGE(16, "Paynet Charge", TransactionTypeOperation.IN, Category.CHARGE, Method.STORE),

    /** Para los casos donde Openpay tiene que devolver saldo al merchant (19) */
    FEE_REFUND(19, "Openpay Back Payment", TransactionTypeOperation.IN, Category.OPENPAY_BACK_PAYMENT,
            Method.OPENPAY),

    /** Para los casos donde Openpay tiene que devolver impuesto al merchant (21) */
    FEE_TAX_REFUND(21, "Openpay Back Payment", TransactionTypeOperation.IN, Category.OPENPAY_BACK_PAYMENT,
            Method.OPENPAY),

    /**  Cargo abona ahorro (23) */
    ABONAHORRO_CHARGE(23, "Abonahorro Charge", TransactionTypeOperation.IN, Category.CHARGE, Method.STORE),

    /** Transaccion del account al que se le esta depositando el reembolso del cobro de una comision. (25) */
    FEE_TO_REFUND(25, "Refund fee to", TransactionTypeOperation.IN, Category.REFUND, Method.CUSTOMER),

    /** Deposito a una cuenta mediante tienda (26) */
    PAYNET_DEPOSIT(26, "Paynet Deposit", TransactionTypeOperation.IN, Category.CHARGE, Method.STORE),

    /** Reembolso a favor del comercio, donde se le regresa el monto del contracargo cobrado. (27) */
    CHARGEBACK_ADJUSTMENT(27, "Adjustment chargeback", TransactionTypeOperation.IN, Category.ADJUSTMENT, Method.CARD),

    /** Cargo mediante bitcoins. (28) */
    BITCOIN_CHARGE(28, "Cargos con bitcoin", TransactionTypeOperation.IN, Category.CHARGE, Method.BITCOIN),

    /** Cargo de ajuste a favor de la cuenta del comercio, para casos excepcionales. (30) */
    ADJUSTMENT_REFUND(30, "Ajuste a favor", TransactionTypeOperation.IN, Category.ADJUSTMENT, Method.OPENPAY),
    
    /** Cargos usando el sistema de QROPay. (32) */
    QROPAY_CHARGE(32, "QROPay Charge", TransactionTypeOperation.IN, Category.CHARGE, Method.QROPAY),
    
    /** Cargos usando Alipay. (33) */
    ALIPAY_CHARGE(33, "Alipay Charge", TransactionTypeOperation.IN, Category.CHARGE, Method.ALIPAY),

    // OUPUTS

    /** Deposito del account hacia un banco. (5) */
    BANK_DEPOSIT(5, "Bank deposit", TransactionTypeOperation.OUT, Category.PAYOUT, Method.BANK_ACCOUNT),

    /** Transaccion del account origen en un traspaso entre accounts. (6) */
    TRANSFER_FROM(6, "Transfer from", TransactionTypeOperation.OUT, Category.TRANSFER, Method.CUSTOMER),

    /** Transaccion del account al que se le esta cobrando una comision. (8) */
    FEE_FROM(8, "Fee from", TransactionTypeOperation.OUT, Category.FEE, Method.CUSTOMER),

    /** Cancelacion de cargo a tarjeta (12) */
    CARD_REFUND(12, "Card Refund", TransactionTypeOperation.OUT, Category.REFUND, Method.CARD),

    /** Transferencia de un account a una tarjeta (13) */
    CARD_DEPOSIT(13, "Card deposit", TransactionTypeOperation.OUT, Category.PAYOUT, Method.CARD),

    /** Pago de fees del merchant. (17) */
    FEE_PAYMENT(17, "Fee payment", TransactionTypeOperation.OUT, Category.OPENPAY_PAYMENT, Method.OPENPAY),

    /** Pago de un pago automatico hacia un banco. (18) */
    AUTOMATIC_BANK_DEPOSIT(18, "Automatic Bank deposit", TransactionTypeOperation.OUT, Category.PAYOUT,
            Method.BANK_ACCOUNT),

    /** Pago de IVA de los fees del merchant. (20) */
    FEE_TAX_PAYMENT(20, "Fee tax payment", TransactionTypeOperation.OUT, Category.OPENPAY_PAYMENT, Method.OPENPAY),

    /** Contracargo aceptado. (22) */
    CHARGEBACK(22, "Chargeback", TransactionTypeOperation.OUT, Category.CHARGEBACK, Method.OPENPAY),

    /** Transaccion del account al que se le esta cobrando el reembolso de una comision. (24) */
    FEE_FROM_REFUND(24, "Refund fee from", TransactionTypeOperation.OUT, Category.REFUND, Method.CUSTOMER),

    /** Reembolso de transacción de bitcoins. (29) */
    BITCOIN_REFUND(29, "Reembolso Bitcoin", TransactionTypeOperation.OUT, Category.REFUND, Method.BITCOIN),

    /** Cargo de ajuste en contra de la cuenta del comercio, para casos excepcionales. (31) */
    ADJUSTMENT_CHARGE(31, "Ajuste en contra", TransactionTypeOperation.OUT, Category.ADJUSTMENT, Method.OPENPAY),

    ;

    public enum Category {
        CHARGE, PAYOUT, TRANSFER, FEE, REFUND, OPENPAY_BACK_PAYMENT, OPENPAY_PAYMENT, CHARGEBACK, ADJUSTMENT;
    }

    public enum Method {
        CARD,REFUND,CHARGEBACK,  BANK_ACCOUNT, CUSTOMER, STORE, OPENPAY, BITCOIN, QROPAY, ALIPAY;
    }

   
    private Integer idTransactionType;

    
    private String description;

    
    private TransactionTypeOperation type;

    
    private Category category;

    
    public Integer getIdTransactionType() {
		return idTransactionType;
	}

	public String getDescription() {
		return description;
	}

	public TransactionTypeOperation getType() {
		return type;
	}

	public Category getCategory() {
		return category;
	}

	public Method getMethod() {
		return method;
	}

	private Method method;

    private TransactionType(final Integer id, final String desc, final TransactionTypeOperation type,
            final Category category, final Method method) {
        this.idTransactionType = id;
        this.description = desc;
        this.type = type;
        this.category = category;
        this.method = method;
    }

    public static TransactionType getById(final Integer id) {
        for (TransactionType type : values()) {
            if (type.idTransactionType.equals(id)) {
                return type;
            }
        }
        return null;
    }

    public static TransactionTypeOperation getOperationTypeById(final Integer id) {
        for (TransactionType type : values()) {
            if (type.idTransactionType.equals(id)) {
                return type.getType();
            }
        }
        return null;
    }

    public static List<Integer> getIdsByCategory(final Category category) {
        List<Integer> ids = new ArrayList<>();
        for (TransactionType type : values()) {
            if (type.category.equals(category)) {
                ids.add(type.getIdTransactionType());
            }
        }
        return ids;
    }

    public static List<Integer> getIdsByType(final TransactionTypeOperation op) {
        List<Integer> ids = new ArrayList<>();
        for (TransactionType type : values()) {
            if (type.type.equals(op)) {
                ids.add(type.getIdTransactionType());
            }
        }
        return ids;
    }
    
    public static List<Integer> getIdsByMethod(final Method method) {
        List<Integer> ids = new ArrayList<>();
        for (TransactionType type : values()) {
            if (type.method.equals(method)) {
                ids.add(type.getIdTransactionType());
            }
        }
        return ids;
    }

    public boolean in(final TransactionType... types) {
        for (TransactionType type : types) {
            if (this.equals(type)) {
                return true;
            }
        }
        return false;
    }
    
    public static List<Integer> getTrxTypeByMethodConciliation(final String method){
        List<Integer> trxIds = new ArrayList<>();
        for (TransactionType type : values()) {
            if (type.method.toString().equals(method.toString())) {
                trxIds.add(type.getIdTransactionType());
            }
        }
        return trxIds;
    }
}
