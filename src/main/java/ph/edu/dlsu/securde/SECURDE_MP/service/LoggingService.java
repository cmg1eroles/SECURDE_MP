package ph.edu.dlsu.securde.SECURDE_MP.service;

import org.springframework.stereotype.Service;
import ph.edu.dlsu.securde.SECURDE_MP.model.*;
import sun.java2d.pipe.SpanShapeRenderer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LoggingService {

    private final static LoggingService instance = new LoggingService();
    private final String filepath = "C:\\boop-files\\logs";

    private LoggingService() {
        Path path = Paths.get(filepath);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static LoggingService getInstance() {
        return instance;
    }

    public boolean logAction(String type, String status, String info) {
        Date now = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat datetimeformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SS");
        String filename = dateformat.format(now);
        String datetime = datetimeformat.format(now);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filepath+"\\"+filename+".txt", true));
            bw.write(datetime + " - " + type + " - " + status + " - " + info);
            bw.newLine();
            bw.flush();
            bw.close();
            return true;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return false;
        }
    }

    public boolean login(User userinfo, boolean success) {
        String status = "SUCCESS";
        if (!success)
            status = "FAILED ATTEMPT";
        String info;
        if (userinfo == null)
            info = "<non-existent user>";
        else info = "[" + userinfo.getId() + "]" + userinfo.getEmail();
        return logAction("LOGIN", status, info);
    }

    public boolean register(User userinfo) {
        String info = "[" + userinfo.getId() + "]" + userinfo.getEmail();
        return logAction("REGISTER", "SUCCESS", info);
    }

    public boolean logout(User userinfo) {
        String info = "[" + userinfo.getId() + "]" + userinfo.getEmail();
        return logAction("LOGOUT", "SUCCESS", info);
    }

    public boolean editProfileInfo(User userinfo) {
        String info = "[" + userinfo.getId() + "]" + userinfo.getEmail();
        return logAction("EDIT PROFILE", "SUCCESS", info);
    }

    public boolean changePassword(User userinfo) {
        String info = "[" + userinfo.getId() + "]" + userinfo.getEmail();
        return logAction("PASSWORD CHANGE", "SUCCESS", info);
    }

    public boolean passwordReset(User userinfo) {
        String info = "[" + userinfo.getId() + "]" + userinfo.getEmail();
        return logAction("RESET PASSWORD", "SUCCESS", info);
    }

    public boolean changeUserStatus(User userinfo, Role role) {
        String info = "[" + userinfo.getId() + "]" + userinfo.getEmail() + " (";
        info += role.getRole() + "), ";
        if (userinfo.getEnabled())
            info += "ENABLED";
        else info += "DISABLED";
        return logAction("USER STATUS CHANGE", "SUCCESS", info);
    }

    public boolean adopt(User adopter, AnimalDetails animal) {
        String info = "[" + adopter.getId() + "]" + adopter.getEmail();
        info += ", animal#:" + animal.getId();
        return logAction("ADOPTION", "SUCCESS", info);
    }

    public boolean addAnimal(User userinfo, AnimalDetails animal) {
        String info = "[" + userinfo.getId() + "]" + userinfo.getEmail();
        info += ", animal#:" + animal.getId();
        return logAction("ANIMAL ADDED", "SUCCESS", info);
    }

    public boolean editAnimalInfo(User userinfo, AnimalDetails animal) {
        String info = "[" + userinfo.getId() + "]" + userinfo.getEmail();
        info += ", animal#:" + animal.getId();
        return logAction("ANIMAL INFO EDITED", "SUCCESS", info);
    }

    public boolean deleteAnimal(User userinfo, AnimalDetails animal) {
        String info = "[" + userinfo.getId() + "]" + userinfo.getEmail();
        info += ", animal#:" + animal.getId();
        return logAction("ANIMAL DELETED", "SUCCESS", info);
    }

    public boolean changeAnimalSstatus(User userinfo, Adoption adoption, Status status) {
        String info = "[" + userinfo.getId() + "]" + userinfo.getEmail();
        info += ", animal#:" + adoption.getAnimalId();
        info += ", " + status.getStatus().toUpperCase();
        return logAction("ANIMAL STATUS CHANGE", "SUCCESS", info);
    }

    public boolean newForum(User userinfo, ForumPost post) {
        String info = "[" + userinfo.getId() + "]" + userinfo.getEmail();
        info += ", [" + post.getId() + "]" + post.getTitle();
        return logAction("NEW FORUM POST", "SUCCESS", info);
    }

    public boolean commentForum(User userinfo, ForumPost post, Comment comment) {
        String info = "[" + userinfo.getId() + "]" + userinfo.getEmail();
        info += ", [" + post.getId() + "]" + post.getTitle();
        info += ", [" + comment.getId() + "]" + comment.getMsg();
        return logAction("NEW FORUM COMMENT", "SUCCESS", info);
    }

    public boolean deleteForum(User userinfo, ForumPost post) {
        String info = "[" + userinfo.getId() + "]" + userinfo.getEmail();
        info += ", [" + post.getId() + "]" + post.getTitle();
        return logAction("DELETE FORUM POST", "SUCCESS", info);
    }
}
