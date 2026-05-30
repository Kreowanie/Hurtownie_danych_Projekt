package HD.projekt.drug.dto;

public record DimTransactionTypeDTO(
        Integer id,
        String transactionType,
        Boolean isCancelled,
        Boolean isReturn
) {
}