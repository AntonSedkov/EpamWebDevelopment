package epam.sedkov.day1.main;

import epam.sedkov.day1.console.OrdinaryPrinter;
import epam.sedkov.day1.console.TrigonometricPrinter;
import epam.sedkov.day1.exception.MyCheckedException;
import epam.sedkov.day1.service.TrigonometricService;

public class Task3 {
    public static void main(String[] args) {
        TrigonometricService trigonometricService = new TrigonometricService();
        TrigonometricPrinter trigonometricPrinter = new TrigonometricPrinter();
        OrdinaryPrinter ordinaryPrinter = new OrdinaryPrinter();

        // Good result
        try {
            trigonometricPrinter.squarePrinter("inscribed square",
                    trigonometricService.receiveSquareOfInscribedSquare(
                            trigonometricService.receiveRadiusOfInscribedCircle(10.25)));
            trigonometricPrinter.howManySmallerPrinter(trigonometricService.howManyTimesInscribedSmallerDescribed(10.25),
                    "inscribed square", "described square");
        } catch (MyCheckedException e) {
            ordinaryPrinter.printException(e);
        }

        // Bad result
        try {
            trigonometricPrinter.squarePrinter("inscribed square",
                    trigonometricService.receiveSquareOfInscribedSquare(
                            trigonometricService.receiveRadiusOfInscribedCircle(0)));
        } catch (MyCheckedException e) {
            ordinaryPrinter.printException(e);
        }

        try {
            trigonometricPrinter.howManySmallerPrinter(trigonometricService.howManyTimesInscribedSmallerDescribed(-777),
                    "inscribed square", "described square");
        } catch (MyCheckedException e) {
            ordinaryPrinter.printException(e);
        }
    }
}