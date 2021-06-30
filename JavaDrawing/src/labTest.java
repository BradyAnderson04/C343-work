import java.util.*;

public class labTest {
	static void main(String[] args) {
		String zoneID = "America/Los_Angeles";
		TimeZone tz = TimeZone.getTimeZone(zoneID);
		System.out.println(tz.getOffset(Calendar.ZONE_OFFSET));
		System.out.println(tz.getDisplayName(false, TimeZone.LONG));
		System.out.println(tz.useDaylightTime());
	}
}
