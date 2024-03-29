package MainFrame.Pages.MainMenu.ForumsPane;

import APIConnection.APIConnection;
import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.Pages.MainMenu.ForumsPane.Forum.ForumModel;
import MainFrame.Pages.MainMenu.ForumsPane.Forum.ForumView;
import Static.SizeConstants;
import PojoClasses.Post;
import PojoClasses.Forum;

import java.util.ArrayList;

public class ForumsPaneModel implements IForumsPaneModel{

    private SizeConstants sc ;
    private IForumsPaneView forumsPaneView;

    /*******************************************************************************************/

    private ArrayList<ForumModel> foumModelList;

    private ArrayList<Forum> forumList; // For the use of getting forums from the database

    /*******************************************************************************************/

    public ForumsPaneModel()
    {
        this.init();
    }

    private void init()
    {
        this.sc = new SizeConstants();

        this.foumModelList = new ArrayList<ForumModel>();

        /******************************************************************/

        this.forumList = null;

        try
        {
            this.forumList = APIConnection.getAllForums();

            for ( Forum forum : this.forumList)
            {
                forum.setupPostList();
            }
        }
        catch (Exception e)
        {
            // Pop up menu no Internet connection

            e.printStackTrace();
        }

        /******************************************************************/

        ForumView loopView = null;
        ForumModel loopModel = null;

         for ( int i = 0 ; i < forumList.size() ; i++)
         {
             loopView = new ForumView();
             loopModel = new ForumModel(forumList.get(i));

             loopModel.setView( loopView );
             foumModelList.add( loopModel );
         }
    }

    /*******************************************************************************************/

    @Override
    public void update()
    {
        this.forumsPaneView.update( this );
    }

    @Override
    public void setView(IForumsPaneView view) {
        this.forumsPaneView = view ;
    }

    @Override
    public CustomJPanel getView() {
        this.update();
        return (CustomJPanel) forumsPaneView;
    }

    /*******************************************************************************************/

    public SizeConstants getSc() {
        return sc;
    }

    public IForumsPaneView getForumsPaneView() {
        return forumsPaneView;
    }

    public ArrayList<ForumModel> getForumList() {
        return foumModelList;
    }

    public void setForumsPaneView(IForumsPaneView forumsPaneView) {
        this.forumsPaneView = forumsPaneView;
    }

    public void setForumList(ArrayList<ForumModel> foumModelList) {
        this.foumModelList = foumModelList;
    }
}