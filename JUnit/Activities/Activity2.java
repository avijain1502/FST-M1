package Activities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class Activity2 {
    @Test
    void notEnoughFunds() {
        BankAccount account = new BankAccount(9);
        assertThrows(NotEnoughFundsException.class, () -> account.withdraw(10));
    }
}
