package ph.edu.dlsu.securde.SECURDE_MP.service;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

@Service
public class BruteForcePreventionService {
    private static final BruteForcePreventionService instance = new BruteForcePreventionService();

    private HashMap<String, Object> attempts = new HashMap<>();

    private BruteForcePreventionService() {}

    public static BruteForcePreventionService getInstance() {
        return instance;
    }

    public HashMap<String, Object> getAttempts() {
        return attempts;
    }

    public void addFailedAttempt(String key) {
        if (!attempts.containsKey(key)) {
            attempts.put(key, new HashMap<String, Object>());
            ((HashMap)attempts.get(key)).put("attempts", 1);
        } else {
            HashMap<String, Object> attempt = (HashMap) attempts.get(key);
            attempt.put("attempts", ((int)attempt.get("attempts"))+1);
            if (((int)attempt.get("attempts")) % 7 == 0) {
                Date enableOn = new Date();
                enableOn.setTime(enableOn.getTime() + ((int)attempt.get("attempts"))/7 * 60 * 1000);
                attempt.put("enable-datetime", enableOn);
            }
            attempts.put(key, attempt);
        }
    }

    public HashMap<String, Object> getAttempt(String key) {
        if (attempts.containsKey(key))
            return (HashMap)attempts.get(key);
        return null;
    }

    public Date getTimeOut(String key) {
        if (attempts.containsKey(key)) {
            HashMap<String, Object> attempt = (HashMap)attempts.get(key);
            if (attempt.containsKey("enable-datetime"))
                return (Date) attempt.get("enable-datetime");
        }
        Date d = new Date();
        d.setTime(0);
        return d;
    }

    public void attemptSuccess(String key) {
        if (attempts.containsKey(key))
            attempts.remove(key);
    }
}
