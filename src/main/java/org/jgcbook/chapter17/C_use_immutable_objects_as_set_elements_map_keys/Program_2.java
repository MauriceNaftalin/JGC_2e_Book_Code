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
		Task codeUi = new CodingTask("code ui", Duration.ofHours(6));
		var project1 = new Project("project1", new HashSet<>(Set.of(codeUi)));

		Task codeDb = new CodingTask("code db", Duration.ofHours(4));
		var project2 = new Project("project2", new HashSet<>(Set.of(codeDb)));

		var projectSet = new TreeSet<>(Comparator
		        .comparing(Project::getTotalDuration)
		        .thenComparing(Project::getName));

		projectSet.addAll(List.of(project1,project2));                           //1
		assert projectSet.contains(project2);
		project2.addTask(new CodingTask("code ai", Duration.ofHours(5)));  //2
		assert ! projectSet.contains(project2);
	}
}