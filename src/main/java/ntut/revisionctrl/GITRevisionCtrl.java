package ntut.revisionctrl;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepository;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public class GITRevisionCtrl implements RevisionCtrl {
	
	public GITRevisionCtrl() {
		Repository localRepo = null;
		try {
			localRepo = new FileRepository("789" + "/.git");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Git git = new Git(localRepo);
		try {
			Git.cloneRepository()
					.setURI("https://github.com/fubof/AutomatedTest.git")
					.setDirectory(new File("789"))
					.setCredentialsProvider(new UsernamePasswordCredentialsProvider("123","456"))
					.call();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void checkout() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
