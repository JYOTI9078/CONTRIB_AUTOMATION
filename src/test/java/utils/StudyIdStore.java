
package utils;

public final class StudyIdStore {
    private static String studyId;

    private StudyIdStore() {}

    public static void set(String value) {
        studyId = value;
        System.out.println("✓ StudyId stored: " + value);
    }

    public static String get() {
        if (studyId == null || studyId.trim().isEmpty()) {
            throw new RuntimeException("studyId is not set. Run Scenario 1 first.");
        }
        return studyId;
    }

    public static void clear() {
        studyId = null;
    }
}