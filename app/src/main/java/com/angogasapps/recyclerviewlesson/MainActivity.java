package com.angogasapps.recyclerviewlesson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler;
    Button button;
    EditText editText;
    MyAdapter adapter;
    LinearLayoutManager linearLayoutManager;
    int a = 0;
    List<Message> messageList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recycler);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);

        initRecycler();
        initButton();
    }

    private void initRecycler() {
        adapter = new MyAdapter(messageList);
        linearLayoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(linearLayoutManager);
        recycler.setAdapter(adapter);
    }

    private void initButton() {
        button.setOnClickListener(v -> {
            String text = editText.getText().toString();
            Message message = new Message(a++, text);
            messageList.add(message);
            adapter.notifyItemInserted(messageList.size() - 1);
        });
    }
}