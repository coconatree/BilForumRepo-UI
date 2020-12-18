package MainFrame.Pages.PostPage.Center;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.Pages.ForumPage.Center.Post.PostModel;
import net.miginfocom.swing.MigLayout;

public class POCenterView extends CustomJPanel implements IPOCenterView {

    @Override
    public void update(POCenterModel model) {
        this.init(model);
    }

    private void init(POCenterModel model) {
        MigLayout layout = new MigLayout("inset 5 15 5 15", "[grow]", this.stringGenerator(model.getPostModels().size(), model));
        this.setLayout(layout);

        for(PostModel mdl : model.getPostModels())
        {
            this.add(mdl.getView(), "grow, wrap");
        }
    }
    private String stringGenerator(int number, POCenterModel model)
    {
        String str = "";

        for(int i = 0; i < number; i++)
        {
            str += String.format("[%d]", model.getSc().getHEIGHT_RATIO() * 10);

            if(i != number)
            {
                str += "10";
            }
        }
        return str;
    }

}