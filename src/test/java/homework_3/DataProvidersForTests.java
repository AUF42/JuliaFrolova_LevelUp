package homework_3;

import org.testng.annotations.DataProvider;
import static jdk.nashorn.internal.objects.Global.Infinity;

/**
 * @author u.frolova
 *
 * Класс программы (@DataProvider), создающий массивы данных для тестов.
 *
 **/

public class DataProvidersForTests {

    @DataProvider(name = "SumLongData")
    public static Object[][] SumLongData() {
        return new Object[][] {
                {12345678901L,123456789L, 12469135690L},
                {-12345678901L, 123456789L, -12222222112L},
                {-12345678901L, 0, -12345678901L},
        };
    }

    @DataProvider(name = "SumDoubleData")
    public static Object[][] SumDoubleData() {
        return new Object[][] {
                {1.5, 4.6, 6.1},
                {-8.9, 4.5, -4.4},
                {-8.444, 0, -8.444},
        };
    }

    @DataProvider(name = "SubLongData")
    public static Object[][] SubLongData() {
        return new Object[][] {
                {12345678901L, 123456789L, 12222222112L},
                {-12345678901L, 123456789L, -12469135690L},
                {-12345678901L, 0, -12345678901L},
        };
    }

    @DataProvider(name = "SubDoubleData")
    public static Object[][] SubDoubleData() {
        return new Object[][] {
                {1.5, 4.8, -3.3},
                {-8.9, -4.5, -4.4},
                {-8.444, 0, -8.444},
        };
    }

    @DataProvider (name = "MtplLongData")
    public static Object[][] MtplLongData() {
        return new Object[][] {
                {12345678901L, 123L, 1518518504823L},
                {12345678901L, -123L, -1518518504823L},
                {-12345678901L, 123L, -1518518504823L},
                {-12345678901L, -123L, 1518518504823L},
                {-12345678901L, 0, 0},
                {0, 12345678901L, 0},
        };
    }

    @DataProvider (name = "MtplDoubleData")
    public static Object[][] MtplDoubleData() {
        return new Object[][] {
                {1.5, 4.6, 6.9},
                {-8.9, -4.5, 40.05},
                {-8.9, 4.5, -40.05},
                {8.9, -4.5, -40.05},
                {-8.444, 0, 0},
                {0, -8.444, 0},
        };
    }

    @DataProvider (name = "DivLongData")
    public static Object[][] DivLongData() {
        return new Object[][] {
                {12345678901L, 12345678901L, 1},
                {-12345678901L, 1, -12345678901L},
                {12345678901L, -1, -12345678901L},
                {-12345678901L, -1, 12345678901L},
                {0, 12345678901L, 0},
                {12345678901L, 0, Infinity},
        };
    }

    @DataProvider (name = "DivDoubleData")
    public static Object[][] DivDoubleData() {
        return new Object[][] {
                {9.8, 4, 2.45},
                {-9.8, 4, -2.45},
                {-9.8, -4, 2.45},
                {9.8, -4, -2.45},
                {-8.444, 0, -Infinity},
                {0, -8.444, 0},
        };
    }

    @DataProvider (name = "PowData")
    public static Object[][] PowDoubleData() {
        return new Object[][] {
                {2, 4, 16},
                {0, 4.666, 0},
                {-2, 9, -512},
                {-2, -5, -0.031},
                {18.97, 0,1},
        };
    }

    @DataProvider (name = "SqrtData")
    public static Object[][] SqrtData() {
        return new Object[][] {
                {0, 0},
                {4, 2},
                {8.4 ,2.898},
                {6 ,2.449},
        };
    }

    @DataProvider (name = "TgData")
    public static Object[][] TgData() {
        return new Object[][] {
                {0, 0},
                {Math.toRadians(45),1},
                {Math.toRadians(60), 1.732},
                {Math.toRadians(180), 0},
        };
    }

    @DataProvider (name = "CtgData")
    public static Object[][] CtgData() {
        return new Object[][] {
                {Math.toRadians(30),1.732},
                {Math.toRadians(45),1},
                {Math.toRadians(90), 0},
                {Math.toRadians(120), -0.577},
        };
    }

    @DataProvider (name = "CosData")
    public static Object[][] CosData() {
        return new Object[][] {
                {0, 1},
                {(Math.PI/3) ,0.5},
                {(Math.PI/2), 0},
                {(Math.PI), -1},
        };
    }

    @DataProvider (name = "SinData")
    public static Object[][] SinData() {
        return new Object[][] {
                {0, 0},
                {Math.PI/6,0.5},
                {Math.PI/2, 1},
                {2, 0.909},
        };
    }

    @DataProvider (name = "PositiveData")
    public static Object[][] PositiveData() {
        return new Object[][] {
                {8 ,true},
                {67 ,true},
                {-4, false},
                {0, false},
        };
    }

    @DataProvider (name = "NegativeData")
    public static Object[][] NegativeData() {
        return new Object[][] {
                {-46, true},
                {56 ,false},
                {-4, true},
                {0, false},
        };
    }
}
