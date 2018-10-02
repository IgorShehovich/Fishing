import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

    public class LessonOop {
        public static void main(String[] args) {
            int[] mas = {6, 7, 3, 6, 9, 3, 4, 2, 5, 5, 4, 9, 9, 3};
            LessonOop lessonOop=new LessonOop();
            lessonOop.countRepeatsLambda(mas);
        }

        public void countRepeats(int[] masInt) {
            Set<Integer> uniq = new TreeSet<>();
            for (Integer temp1 : masInt) {
                uniq.add(temp1);
            }
            for (Integer temp : uniq) {
                int count = 0;
                for (int i = 0; i < masInt.length; i++) {
                    if (temp == masInt[i]) {
                        count++;
                    }
                }
                if (count > 1) {
                    System.out.println(temp + "repeated " + count + " times");
                }
            }
        }

        public void countRepeatsLambda(int[] mass) {
            Arrays.stream(mass).sorted().distinct().forEach(w-> {
                long count2 = Arrays.stream(mass).filter(n -> n == w).count();
                System.out.println(w + " repeated " + count2 + " times");
            });
        }
    }

