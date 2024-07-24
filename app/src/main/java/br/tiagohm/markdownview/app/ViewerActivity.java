package br.tiagohm.markdownview.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

import br.tiagohm.markdownview.MarkdownView;
import br.tiagohm.markdownview.css.InternalStyleSheet;
import br.tiagohm.markdownview.css.styles.Bootstrap;
import br.tiagohm.markdownview.css.styles.Github;

public class ViewerActivity extends AppCompatActivity {
    private MarkdownView mMarkdownView;
    private InternalStyleSheet mCurrentStyle;
    private final InternalStyleSheet mStyleGithub = new Github();
    private final InternalStyleSheet mStyleBootstrap = new Bootstrap();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.change_theme_action) {
            if (mCurrentStyle == mStyleGithub) {
                mMarkdownView.replaceStyleSheet(mCurrentStyle, mStyleBootstrap);
                mCurrentStyle = mStyleBootstrap;
            } else {
                mMarkdownView.replaceStyleSheet(mCurrentStyle, mStyleGithub);
                mCurrentStyle = mStyleGithub;
            }
            loadContent(getIntent());
        }

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCurrentStyle = mStyleGithub;
        mMarkdownView = findViewById(R.id.mark_view);
        mMarkdownView.addStyleSheet(mCurrentStyle);

        loadContent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        loadContent(intent);
    }

    private void loadContent(Intent intent) {
        Uri uri = intent.getData();
        try {
            File file = FileUtil.from(this, uri);
            if (file.exists()) {
                mMarkdownView.loadMarkdownFromFile(file);
                return;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        mMarkdownView.loadMarkdownFromAsset("MarkdownDemo.md");
    }
}