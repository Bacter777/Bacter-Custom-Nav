package com.bacter.bacter.helper;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.bacter.bacter.R;
import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

public class SampleHelper implements View.OnClickListener
{
    private Activity activity;

    private SampleHelper(Activity activity)
    {
        this.activity = activity;
    }
    public static SampleHelper with(Activity activity)
    {
        return new SampleHelper(activity);
    }
    public void loadAbout()
    {
        final FrameLayout f1Holder = activity.findViewById(R.id.about);
        AboutBuilder builder = AboutBuilder.with(activity)
                .setPhoto(R.drawable.dev_bacter)
                .setCover(R.drawable.exit)
                .setBrief(R.string.about_bacter)
                .setLinksAnimated(true)
                .setDividerDashGap(13)
                .setName(R.string.dev)
                .setSubTitle(R.string.app_dev)
                .setLinksColumnsCount(3)
                .addGitHubLink("Bacter777")
                .addFacebookLink("BdFreak777")
                .addEmailLink("bdfreak777@gmail.com")
                .addFiveStarsAction()
                .setVersionNameAsAppSubTitle()
                .addPrivacyPolicyAction("https://triskelion.flycricket.io/privacy.html")
                .addShareAction(R.string.app_name)
                .setActionsColumnsCount(2)
                .setVersionNameAsAppSubTitle()
                .addFeedbackAction("bdfreak777@gmail.com")
                .setWrapScrollView(true)
                .setShowAsCard(true);
        AboutView view = builder.build();
        f1Holder.addView(view);
    }
    @Override
    public void onClick(View v) {

    }
}
