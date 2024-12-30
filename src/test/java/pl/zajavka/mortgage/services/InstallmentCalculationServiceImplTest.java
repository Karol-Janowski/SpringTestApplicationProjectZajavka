package pl.zajavka.mortgage.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.zajavka.mortgage.fixtures.TestDataFixtures;
import pl.zajavka.mortgage.model.InputData;
import pl.zajavka.mortgage.model.Installment;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InstallmentCalculationServiceImplTest {

    @InjectMocks
    private InstallmentCalculationServiceImpl installmentCalculationService;

    @Mock
    private TimePointCalculationService timePointCalculationService;

    @Mock
    private AmountsCalculationService amountsCalculationService;

    @Mock
    private ResidualCalculationService residualCalculationService;

    @Mock
    private ReferenceCalculationService referenceCalculationService;

    @Mock
    private OverpaymentCalculationService overpaymentCalculationService;

    @Test
    void thatInstallmentAreCalculatedCorrectly() {
        //given
        final var inputData = TestDataFixtures.someInputData();

        when(whenoverpaymentCalculationService.calculate(any(BigDecimal.class), any(InputData.class))).thenReturn();
        when(whoverpaymentCalculationService.calculate(any(BigDecimal.class), any(Installment.class))).thenReturn();
        when(wheoverpaymentCalculationService.calculate()).thenReturn();
        when(whenoverpaymentCalculationService.calculate()).thenReturn();
        when(overpaymentCalculationService.calculate()).thenReturn();

        //when
        final var result = installmentCalculationService.calculate(inputData);

        //then
        Assertions.assertEquals(null, result);
    }


}