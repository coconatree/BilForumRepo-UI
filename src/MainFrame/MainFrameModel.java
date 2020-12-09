package MainFrame;

import MainFrame.CustomComponents.CustomJFrame;
import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.Navbar.INavbarView;
import MainFrame.Navbar.NavbarController;
import MainFrame.Navbar.NavbarModel;
import MainFrame.Navbar.NavbarView;
import MainFrame.Pages.ForumPage.ForumPageController;
import MainFrame.Pages.ForumPage.ForumPageModel;
import MainFrame.Pages.ForumPage.ForumPageView;
import MainFrame.Pages.ForumPage.IForumPageView;
import MainFrame.Pages.MainMenu.MainMenuController;
import MainFrame.Pages.MainMenu.MainMenuModel;
import MainFrame.Pages.MainMenu.MainMenuView;
import MainFrame.Pages.PostCreationPage.PostCreationPageController;
import MainFrame.Pages.PostCreationPage.PostCreationPageModel;
import MainFrame.Pages.PostCreationPage.PostCreationPageView;
import MainFrame.Pages.ProfilePage.ProfilePageController;
import MainFrame.Pages.ProfilePage.ProfilePageModel;
import MainFrame.Pages.ProfilePage.ProfilePageView;
import Static.SizeConstants;

import javax.swing.*;
import java.awt.*;

public class MainFrameModel implements IMainFrameModel
{
    private SizeConstants sc;

    private IMainFrameView MFV;

    /*******************************************************************************************/

    private NavbarModel NBM;
    private INavbarView NBV;
    private NavbarController NBC;

    /*******************************************************************************************/

    private ForumPageModel FPM;
    private IForumPageView FPV;
    private ForumPageController FPC;

    /*******************************************************************************************/

    private PostCreationPageModel PostCreationPageModel;
    private PostCreationPageView PostCreationPageView;
    private PostCreationPageController PostCreationController;

    /*******************************************************************************************/

    private ProfilePageModel ProfilePageModel;
    private ProfilePageView ProfilePageView;
    private ProfilePageController ProfilePageController;

    /*******************************************************************************************/

    private MainMenuView MMV;
    private MainMenuModel MMM;
    private MainMenuController MMC;

    /*******************************************************************************************/

    private CustomJPanel cardPanel;

    private CardLayout cardLayout;

    /*******************************************************************************************/

    private CustomJPanel panel;
    private JLabel labelTemp;

    public MainFrameModel()
    {
        this.init();
    }

    private void init()
    {
        this.sc = new SizeConstants();

        this.createNavbar();

        this.createForumPage();
        this.createPostCreationPage();
        this.createProfilePage();
        this.createMainMenu();

        this.cardPanel = new CustomJPanel();

        /******************/

        this.panel = new CustomJPanel();
        this.labelTemp= new JLabel();
        this.labelTemp.setText("DENEME");

    }

    private void createMainMenu()
    {
        this.MMV = new MainMenuView();
        this.MMM = new MainMenuModel(this);
        this.MMC = new MainMenuController(this.MMM, this.MMV);

        this.MMM.setView(this.MMV);
    }

    private void createNavbar()
    {
        this.NBV = new NavbarView();
        this.NBM = new NavbarModel(this);
        this.NBC = new NavbarController(this.NBV, this.NBM);

        this.NBM.setView(this.NBV);
    }

    private void createForumPage()
    {
        this.FPV = new ForumPageView();
        this.FPM = new ForumPageModel(this);
        this.FPC = new ForumPageController(this.FPV, this.FPM);

        this.FPM.setView(this.FPV);
    }

    private void createPostCreationPage()
    {
        this.PostCreationPageView   = new PostCreationPageView();
        this.PostCreationPageModel  = new PostCreationPageModel();
        this.PostCreationController = new PostCreationPageController(this.PostCreationPageView, this.PostCreationPageModel);

        this.PostCreationPageModel.setView(this.PostCreationPageView);
    }

    private void createProfilePage()
    {
        this.ProfilePageView = new ProfilePageView();
        this.ProfilePageModel  = new ProfilePageModel();
        this.ProfilePageController = new ProfilePageController();

        this.ProfilePageModel.setView(this.ProfilePageView);
    }

    /*******************************************************************************************/

    @Override
    public void update()
    {
        this.MFV.update(this);
    }

    @Override
    public void setView(IMainFrameView MFV)
    {
        this.MFV = MFV;
    }


    @Override
    public CustomJFrame getView()
    {
        this.update();
        return (CustomJFrame) this.MFV;
    }

    /*******************************************************************************************/

    public CustomJPanel getNavbarView()
    {
        this.NBM.update();
        return (CustomJPanel) this.NBV;
    }

    /*******************************************************************************************/

    public SizeConstants getSc()
    {
        return this.sc;
    }

    /*******************************************************************************************/

    public ProfilePageModel getProfilePageModel()
    {
        return this.ProfilePageModel;
    }

    public PostCreationPageModel getPostCreationPageModel()
    {
        return this.PostCreationPageModel;
    }

    public ForumPageModel getFPM()
    {
        return this.FPM;
    }

    public NavbarModel getNVM()
    {
        return this.NBM;
    }

    /*******************************************************************************************/

    public CustomJPanel getCardPanel()
    {
        return this.cardPanel;
    }

    public CardLayout getCardLayout()
    {
        return this.cardLayout;
    }

    public void setCardLayout(CardLayout layout)
    {
        this.cardLayout = layout;
    }

    /*********************************************************************************************/

    public CustomJPanel getPanel()
    {
        return panel;
    }

    public JLabel getLabelTemp()
    {
        return labelTemp;
    }

    public MainMenuModel getMMM()
    {
        return MMM;
    }
}