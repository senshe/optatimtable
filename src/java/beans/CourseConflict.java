/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 * @author ElBastamy
 */
public class CourseConflict implements Serializable, Comparable<CourseConflict> {

    private final Course leftCourse;
    private final Course rightCourse;
    private final int conflictCount;

    public CourseConflict(Course leftCourse, Course rightCourse, int conflictCount) {
        this.leftCourse = leftCourse;
        this.rightCourse = rightCourse;
        this.conflictCount = conflictCount;
    }

    public Course getLeftCourse() {
        return leftCourse;
    }

    public Course getRightCourse() {
        return rightCourse;
    }

    public int getConflictCount() {
        return conflictCount;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof CourseConflict) {
            CourseConflict other = (CourseConflict) o;
            return new EqualsBuilder()
                    .append(leftCourse, other.leftCourse)
                    .append(rightCourse, other.rightCourse)
                    .isEquals();
        } else {
            return false;
        }
    }

    public int hashCode() {
        return new HashCodeBuilder()
                .append(leftCourse)
                .append(rightCourse)
                .toHashCode();
    }

    public int compareTo(CourseConflict other) {
        return new CompareToBuilder()
                .append(leftCourse, other.leftCourse)
                .append(rightCourse, other.rightCourse)
                .toComparison();
    }

    @Override
    public String toString() {
        return leftCourse + " & " + rightCourse;
    }

}
