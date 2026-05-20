package elearning.interfaces;

import elearning.courses.Course;
import elearning.exceptions.CourseFullException;

public interface Enrollable {

    void enroll(Course course) throws CourseFullException;
}