import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.radio.Radio;

public class RadioTest {
    @Test

    public void testParametrizedConstructor() { //тестирует параметризованный конструктор
        Radio radio = new Radio(30);

        Assertions.assertEquals(0, radio.getMinStation());
        Assertions.assertEquals(29, radio.getMaxStation());
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void testUnParametrizedConstructor() { //тестирует непараметризованный конструктор
        Radio radio = new Radio();

        Assertions.assertEquals(0, radio.getMinStation());
        Assertions.assertEquals(9, radio.getMaxStation());
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }



    @Test
    public void getCurrentStation() { //получить номер текущей радиостанции
        Radio radio = new Radio(30);
        radio.setCurrentStation(8);

        int expected = 8;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setDirectly() { //переключает непосредственно при допустимых значениях
        Radio radio = new Radio(30);
        radio.setCurrentStation(7);

        int expected = 7;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setDirectlyAboveMax() { //переключает непосредственно при значениях больше 9
        Radio radio = new Radio(30);

        radio.setCurrentStation(30);

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setDirectlyBelowMin() { //переключает непосредственно при значениях меньше 0
        Radio radio = new Radio(30);
        radio.setCurrentStation(-1);

        int expected = 29;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setNext() { //переключение на следующую радиостанцию
        Radio radio = new Radio(30);
        radio.setCurrentStation(5);

        radio.next();

        int expected = 6;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setPrevious() { //переключение на предыдущую радиостанцию
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        radio.prev();

        int expected = 4;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void returnZeroIfAboveMax() { //переключает на минимальное при нажатии next при максимальном значении
        Radio radio = new Radio(30);
        radio.setCurrentStation(29);

        radio.next();

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void returnNineIfBelowMin() { //переключает на максимальное при нажатии prev при минимальном значении
        Radio radio = new Radio(30);
        radio.setCurrentStation(0);

        radio.prev();

        int expected = 29;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);

    }

    //тесты на уровень громкости

    @Test
    public void getCurrentVolume() { //получить текущий уровень громкости
        Radio radio = new Radio(100);
        radio.setCurrentVolume(78);

        int expected = 78;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void increaseVolume() { //прибавить громкость
        Radio radio = new Radio(100);
        radio.setCurrentVolume(98);

        radio.increaseVolume();

        int expected = 99;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void reduceVolume() { //убавить громкость
        Radio radio = new Radio(100);
        radio.setCurrentVolume(99);


        int expected = 98;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notSetAboveMax() { //выставление громкости больше максимального значения
        Radio radio = new Radio();
        radio.setCurrentVolume(100);

        radio.increaseVolume();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notSetBelowMin() { //выставление громкости меньше минимального значения
        Radio radio = new Radio(100);
        radio.setCurrentVolume(0);

       

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

}