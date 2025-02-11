package org.jgcbook.chapter17.C_use_immutable_objects_as_set_elements_map_keys;
// 19c2
import org.jgcbook.chapter17.B_ownership.Project;
import org.jgcbook.chapter17.A_avoid_anemic_domain_models.Task;
import org.jgcbook.chapter17.A_avoid_anemic_domain_models.CodingTask;
import java.time.Duration;
import java.util.TreeSet;
import java.util.Set;
import java.util.Comparator;
import java.util.List;
import java.util.HashSet;

public class Program_2 {
	public static void main(String[] args)  {
		Task codeUi = new CodingTask("code ui", Duration.ofHours(4));
		var project1 = new Project("project1", new HashSet<>(Set.of(codeUi)));
		Task codeDb1 = new CodingTask("code db1", Duration.ofHours(3));
		Task codeDb2 = new CodingTask("code db2", Duration.ofHours(3));
		var project2 = new Project("project2", new HashSet<>(Set.of(codeDb2, codeDb1)));
		var projectSet = new TreeSet<>(Comparator
		        .comparing(Project::getTotalDuration)
		        .thenComparing(Project::getName));
		projectSet.addAll(List.of(project1,project2));                      //1
		assert projectSet.contains(project2);                               //2
		project2.removeTask(codeDb2);
		assert ! projectSet.contains(project2);                             //3

	}
}