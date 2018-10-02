import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Fishing {
    public static void main(String[] args) {
        Fish goby = new Fish("goby", 1);
        Fish goby1 = new Fish("goby", 2);
        Fish perch = new Fish("perch", 2);
        Fish perch1 = new Fish("perch", 3);

        Fishing go = new Fishing();
        go.fishing(LocalDate.of(2018, Month.SEPTEMBER,20), goby);
        go.fishing(LocalDate.of(2018,Month.SEPTEMBER,14), goby1);
        go.fishing(LocalDate.of(2018,Month.SEPTEMBER,7), perch);
        go.fishing(LocalDate.of(2018,Month.SEPTEMBER,16),perch1);
        go.reportForFish(LocalDate.of(2018,Month.SEPTEMBER,1),LocalDate.of(2018,Month.SEPTEMBER,30));
    }

    public void fishing(LocalDate date, Fish fish) {
        Collection<Fish> temp = total.get(date);
        if (temp != null) {
            temp.add(fish);
        } else {
            Collection<Fish> temp1 = new ArrayList<>();
            temp1.add(fish);
            total.put(date, temp1);
        }
    }


    public void reportForFish(LocalDate start, LocalDate finish) {
        Collection<Fish> setka = new ArrayList<>();
        int totalWeightGoby = 0;
        int totalWeightPerch = 0;
        LocalDate start1 = start.isBefore(finish) ? start : finish;
        LocalDate finish1 = finish.isBefore(start) ? start : finish;
        Set<Map.Entry<LocalDate, Collection<Fish>>> fishka = total.entrySet();
        for (Map.Entry<LocalDate, Collection<Fish>> temp : fishka) {
            if (temp.getKey().isAfter(start1) & temp.getKey().isBefore(finish)) {
                setka.addAll(temp.getValue());
            }
        }
        for (Fish tempq : setka) {
            if (tempq.name == "goby") {
                totalWeightGoby=totalWeightGoby+tempq.weight;
            }else{
                totalWeightPerch = totalWeightPerch+tempq.weight;
            }
        }
        System.out.println("Goby  " + totalWeightGoby + ", Perch " + totalWeightPerch);
    }

    Map<LocalDate, Collection<Fish>> total = new TreeMap<>();
}

class Fish {
    String name;
    int weight;

    public Fish(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }


}


