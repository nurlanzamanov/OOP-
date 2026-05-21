package elearning.interfaces;
import elearning.content.Assignment;
import elearning.exceptions.DeadlinePassedException;

public interface Submittable {
    void submit(Assignment assignment, String answer) throws DeadlinePassedException;
}
