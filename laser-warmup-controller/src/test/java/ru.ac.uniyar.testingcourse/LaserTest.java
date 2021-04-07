package ru.ac.uniyar.testingcourse;
import mockit.Mock;
import mockit.MockUp;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
public class LaserTest {
    public static final class SystemTimeMock extends MockUp<System>{
        long mockedTime = 0;
        public void setMockedTime(long mockedTime){
            this.mockedTime = mockedTime;

        }
        @Mock
        long currentTimeMillis(){
            return mockedTime;
        }
        SystemTimeMock systemTimeMock = new SystemTimeMock();
        @Test
        void simpleCase(){
            systemTimeMock.setMockedTime(0);
            WarmupController contr = new WarmupController();
            contr.markLaserOn();
            systemTimeMock.setMockedTime(120000);
            assertThat(contr.getRemainingTime()).isEqualTo(0.0);
        }

        @Test
        void foolCooling(){
            systemTimeMock.setMockedTime(0);
            WarmupController contr = new WarmupController();
            contr.markLaserOn();

            systemTimeMock.setMockedTime(120000);
            contr.markLaserOff();
            systemTimeMock.setMockedTime(180000);
            contr.markLaserOn();
            assertThat(contr.getRemainingTime()).isEqualTo(120.0);
        }
    }
}
