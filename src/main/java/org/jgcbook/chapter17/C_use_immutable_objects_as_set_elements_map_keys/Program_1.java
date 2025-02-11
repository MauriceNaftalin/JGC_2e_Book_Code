package org.jgcbook.chapter17.C_use_immutable_objects_as_set_elements_map_keys;
// 19c1
import org.jgcbook.chapter17.B_ownership.Project;
import org.jgcbook.chapter17.A_avoid_anemic_domain_models.Task;
import org.jgcbook.chapter17.A_avoid_anemic_domain_models.CodingTask;
import org.jgcbook.chapter17.A_avoid_anemic_domain_models.PhoneTask;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

public class Program_1 {
	public static void main(String[] args)  {
		var tasks = new HashSet<Task>(Set.of(new CodingTask("code ui", Duration.ofHours(4))));
		var myProject = new Project("My Project", tasks);
		var projectSet = new HashSet<>(Set.of(myProject));
		assert projectSet.contains(myProject);
		myProject.addTask(new CodingTask("code db", Duration.ofHours(6)));
		assert ! projectSet.contains(myProject);

	}
}