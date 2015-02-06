package ntut.revisionctrl;

import java.io.File;

import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

public class SVNRevisionCtrl implements RevisionCtrl {

	public SVNRevisionCtrl() throws SVNException {
		String url = "svn://140.124.181.5/PHP_Unit_fb";
		String name = "foboo";
		String password = "foboo";
		SVNRepository repository = SVNRepositoryFactory.create(SVNURL
				.parseURIEncoded(url));
		ISVNAuthenticationManager authManager = SVNWCUtil
				.createDefaultAuthenticationManager(name, password);
		repository.setAuthenticationManager(authManager);
		SVNClientManager ourClientManager = SVNClientManager.newInstance(null,
				repository.getAuthenticationManager());
		SVNUpdateClient updateClient = ourClientManager.getUpdateClient();
		updateClient.setIgnoreExternals(false);
		updateClient.doCheckout(SVNURL.parseURIEncoded(url), new File("456/"),
				SVNRevision.HEAD, SVNRevision.HEAD, SVNDepth.INFINITY, false);
	}

	@Override
	public void checkout() {
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
