package kg.megacom;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Main {

    public static void main(String[] args) {

            ZoneId zone1 = ZoneId.of("Europe/Paris");
            ZoneId zone2 = ZoneId.of("Pacific/Midway");
            ZoneId zoneWithRegion = ZoneId.of("UTC+4");
            ZoneId zoneWithOffset = ZoneId.of("+03:00:00");

        DateTimeFormatter formatDesign1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        DateTimeFormatter formatDesign2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        DateTimeFormatter formatDesign3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);

        Instant todayTimeIs = Instant.now();



        CometFlyingAroundEarth cometAazai = new CometFlyingAroundEarth(LocalDateTime.parse("1689-11-03T10:15:30"), Instant.parse("2990-12-03T10:15:30.00Z"));
        CometFlyingAroundEarth cometBowser = new CometFlyingAroundEarth(LocalDateTime.parse("1500-09-03T10:15:30"), Instant.parse("3000-12-03T10:15:29.00Z"));
        System.out.println("Hour of the time of creation of comet Aazai: " + cometAazai.getTimeOfCreation().getHour());
        System.out.println("Minute of the time of creation of comet Aazai: " + cometAazai.getTimeOfCreation().getMinute());

        Duration durationBetweenNowAndCometAazai = Duration.between(todayTimeIs, cometAazai.getTimeOfArrival());
        Duration durationBetweenCometBowserAndNow = Duration.between(cometBowser.getTimeOfArrival(), todayTimeIs);

        System.out.println("");

        System.out.println("Duration of seconds between time of arrival of Bowser and now(it's obviously negative): " + durationBetweenCometBowserAndNow.get(ChronoUnit.SECONDS));
        System.out.println("Finding absolute value for duration(it's always positive): " + durationBetweenCometBowserAndNow.abs().get(ChronoUnit.SECONDS));

        System.out.println("");

        if(cometAazai.getTimeOfArrival().isBefore(cometBowser.getTimeOfArrival())){
            System.out.println("Comet of Aazai arrives first");
        }else{
            System.out.println("Comet of Bowser arrives first");
        }

        System.out.println("");

        System.out.println("Aazai comet's time of creation in the FULL format: " + cometAazai.getTimeOfCreation().format(formatDesign1));
        System.out.println("Aazai comet's time of creation in the MEDIUM format: " + cometAazai.getTimeOfCreation().format(formatDesign2));
        System.out.println("Aazai comet's time of creation in the LONG format: " + cometAazai.getTimeOfCreation().format(formatDesign3));

        System.out.println("");


        //it's block of zones below:
        ZonedDateTime ofCometAazai = cometAazai.getTimeOfArrival().atZone(zone1);
        ZonedDateTime ofCometBowser = cometBowser.getTimeOfArrival().atZone(zone2);
        ZonedDateTime ofCometAazaiWithRegion = cometAazai.getTimeOfArrival().atZone(zoneWithRegion);
        ZonedDateTime ofCometBowserWithOffset = cometBowser.getTimeOfArrival().atZone(zoneWithOffset);
        //here it ends


        System.out.println("Comet Aazais zoned time: " + ofCometAazai + ", " + "Bowser comet's zoned time: " + ofCometBowser);
        System.out.println("Comet Aazais zoned time with region: " + ofCometAazaiWithRegion + ", " + "Bowser comet's zoned time with offset: " + ofCometBowserWithOffset);

        long hoursBetween = ChronoUnit.HOURS.between(ofCometAazai, ofCometBowser);
        long secondsBetween = ChronoUnit.SECONDS.between(ofCometAazai, ofCometBowser);

        System.out.println("Hours between arrival of two comets with their zones: " + hoursBetween);
        System.out.println("Seconds between arrival of two comets with their zones: " + secondsBetween);

        System.out.println("");

        System.out.println("Seconds before apocalypse: " + durationBetweenNowAndCometAazai.getSeconds());
        System.out.println("Nanoseconds before apocalypse, without considering years, hours, seconds etc: " + durationBetweenNowAndCometAazai.getNano());
        System.out.println("Days before apocalypse: " + ChronoUnit.DAYS.between(todayTimeIs, cometAazai.getTimeOfArrival()));

        System.out.println("");

        System.out.println("Time of creation of comet Aazai with 3 days of month: " + cometAazai.getTimeOfCreation().withDayOfMonth(3));
        System.out.println("Time of creation of comet Aazai with 34 days of year: " + cometAazai.getTimeOfCreation().withDayOfYear(34));
        System.out.println("Time of creation of comet Aazai with 12 months will be: " + cometAazai.getTimeOfCreation().withMonth(12));
        System.out.println("Time of creation of comet Aazai with 59 seconds will be: " + cometAazai.getTimeOfCreation().withSecond(59));

        System.out.println("");

        Instant truncatedToHoursTimeOfArrival = cometAazai.getTimeOfArrival().truncatedTo(ChronoUnit.HOURS);
        Instant truncatedToDaysTimeOfArrival = cometAazai.getTimeOfArrival().truncatedTo(ChronoUnit.DAYS);

        System.out.println("Time of arrival of comet Aazai if we don't need precision to hours: " + truncatedToHoursTimeOfArrival);
        System.out.println("Time of arrival of comet Aazai if we don't need precision to days: " + truncatedToDaysTimeOfArrival);

    }
}