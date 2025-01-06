package faang.school.paymentservice.service.payment;


import faang.school.paymentservice.client.OpenExchangeRatesClient;
import faang.school.paymentservice.dto.Currency;
import faang.school.paymentservice.dto.PaymentRequest;
import faang.school.paymentservice.exception.NoSuchCurrencyException;
import faang.school.paymentservice.model.ExchangeRatesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor

public class CurrencyConverterService {

    private final OpenExchangeRatesClient openExchangeRatesClient;
    private final FeeCalculatorService feeCalculatorService;
    private final static double FEE_PERCENT = 1.0;

    public BigDecimal convertCurrencyToUSD(PaymentRequest paymentRequest) {
        if (paymentRequest.currency().equals(Currency.USD)) {
            return paymentRequest.amount();
        }

        ExchangeRatesResponse exchangeRatesResponse = openExchangeRatesClient.getRates();

        List<BigDecimal> rateList = exchangeRatesResponse.getRates().entrySet().stream()
                .filter(entry -> entry.getKey().equals(paymentRequest.currency().toString()))
                .map(Map.Entry::getValue)
                .toList();

        BigDecimal rate = rateList.stream().findFirst().orElseThrow(() -> new NoSuchCurrencyException("There is no such currency"));

        BigDecimal convertedAmount = rate.multiply(paymentRequest.amount());
        return addFee(convertedAmount);
    }

    private BigDecimal addFee(BigDecimal convertedAmount) {
        BigDecimal fee = feeCalculatorService.calculateFee(convertedAmount, FEE_PERCENT);
        return convertedAmount.add(fee);

    }


}
