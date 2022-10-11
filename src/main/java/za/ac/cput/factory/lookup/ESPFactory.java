package za.ac.cput.factory.lookup;

/* ESPFactory.java
   Factory for the EmergencyServiceProvider
   Author: Joshua Daniel Jonkers(215162668)
   Date: 22/05/2022
 */

import za.ac.cput.domain.lookup.EmergencyServiceProvider;
import za.ac.cput.util.Helper;

public class ESPFactory {
    public static EmergencyServiceProvider createESP(String serviceName, String type, String phoneNum) {
        String serviceID = Helper.generateID();

        if (Helper.isNullOrEmpty(serviceName) || Helper.isNullOrEmpty(type) || Helper.isNullOrEmpty(phoneNum))
            throw new IllegalStateException("Invalid Values");

        var esp = new EmergencyServiceProvider.Builder()
                                                                    .setServiceID(serviceID)
                                                                    .setServiceName(serviceName)
                                                                    .setType(type)
                                                                    .setPhoneNum(phoneNum)
                                                                    .build();
        return esp;
    }
}
