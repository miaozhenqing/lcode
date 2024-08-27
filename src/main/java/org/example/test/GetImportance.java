package org.example.test;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class GetImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = employees.stream().collect(Collectors.toMap(e -> e.id, e2 -> e2));
        return dps(map, id);
    }

    public int dps(Map<Integer, Employee> map, int id) {
        if (!map.containsKey(id)) {
            return 0;
        }
        Employee employee = map.get(id);
        int result = employee.importance;
        for (Integer subId : employee.subordinates) {
            result += dps(map, subId);
        }
        return result;
    }

    public static void main(String[] args) {
        //输入：employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
        //输出：11
        List<Employee> employees = Lists.newArrayList();
        Employee employee = new Employee(1, 5, Lists.newArrayList(2, 3));
        employees.add(employee);
        employee = new Employee(2, 3, Lists.newArrayList());
        employees.add(employee);
        employee = new Employee(3, 3, Lists.newArrayList());
        employees.add(employee);
        System.out.println(new GetImportance().getImportance(employees, 1));//11
    }

    public static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }
}
