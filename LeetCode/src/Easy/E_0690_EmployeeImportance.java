package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/employee-importance/
 */
public class E_0690_EmployeeImportance {

	public static class Employee {
		// It's the unique id of each node;
		// unique id of this employee
		public int id;
		// the importance value of this employee
		public int importance;
		// the id of direct subordinates
		public List<Integer> subordinates;
		public Employee(int id, int importance, List<Integer> subordinates){
	        this.id = id;
	        this.importance = importance;
	        this.subordinates = subordinates;
	    }
	};
	
	Map<Integer, Employee> emap;
	public int getImportance(List<Employee> employees, int queryid) {
		emap = new HashMap();
		for (Employee e: employees) emap.put(e.id, e);
		return dfs(queryid);
	}
	public int dfs(int eid) {
		Employee employee = emap.get(eid);
		int ans = employee.importance;
		for (Integer subid: employee.subordinates)
			ans += dfs(subid);
		return ans;
	}
	
	public static void main(String[] args) {
		E_0690_EmployeeImportance obj = new E_0690_EmployeeImportance();
		Employee e1 = new Employee(1, 5, new ArrayList<>(Arrays.asList(2, 3)));
		Employee e2 = new Employee(2, 3, new ArrayList<>());
		Employee e3 = new Employee(3, 3, new ArrayList<>());
		
		List<Employee> employees = new ArrayList<Employee>(Arrays.asList(e1, e2, e3));
		System.out.println(obj.getImportance(employees, 1));
	}
}
