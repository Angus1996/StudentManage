package com.example.a88481.studentmanage;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.a88481.studentmanage.DAL.StudentService;
import com.example.a88481.studentmanage.Model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener{
    private Button btnAdd;
    private Button btnDelete;

    private List<Student> students;
    private List<Map<String,Object>> data;
    private SimpleAdapter adapter;
    private ListView lvStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.init();
    }

    private void init(){
        this.btnAdd = (Button)this.findViewById(R.id.btnAdd);
        this.btnDelete = (Button)this.findViewById(R.id.btnDelete);

        this.btnAdd.setOnClickListener(this);
        this.btnDelete.setOnClickListener(this);

//        this.btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

//        Student zhangsan = new Student("张三","软件-1403","18899999999","12345678");
//        StudentService.add(zhangsan);
//
//        Student lisi = new Student("李四","电子-1401","16644445444","234533");
//        StudentService.add(lisi);
//
//        Student wangwu = new Student("王五","计科-1401","18891111111","3322322");
//        StudentService.add(wangwu);
//
//        Student wangwu1 = new Student("王五1","计科-1401","18891111111","3322322");
//        StudentService.add(wangwu1);
//
//        Student wangwu2 = new Student("王五2","计科-1401","18891111111","3322322");
//        StudentService.add(wangwu2);
//
//
//        Student wangwu3 = new Student("王五3","计科-1401","18891111111","3322322");
//        StudentService.add(wangwu3);
//
//
//        Student wangwu4 = new Student("王五4","计科-1401","18891111111","3322322");
//        StudentService.add(wangwu4);
//
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);
//        StudentService.add(wangwu4);


        this.students = StudentService.getStudents();

        this.lvStudents = (ListView)this.findViewById(R.id.lvStudents);

        this.initData();

    }

    private void initData(){
        this.data = new ArrayList<Map<String,Object>>();

        for (int index=0;index<this.students.size();index++){
            Student student = this.students.get(index);
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("name",student.getName());
            map.put("major",student.getMajor());
            map.put("phoneNumber",student.getPhoneNumber());
            map.put("qq",student.getQq());
            data.add(map);
        }

        this.adapter = new SimpleAdapter(this,data,R.layout.student_item,
                new String[]{"name","major","phoneNumber","qq"},
                new int[]{R.id.txtName,R.id.txtMajor,R.id.txtPhoneNumber,R.id.txtQQ});

        this.lvStudents.setAdapter(this.adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnAdd:

                final View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.add_student,null);

                new AlertDialog.Builder(this)
                        .setTitle(R.string.add_student)
                        .setView(dialogView)
                        //.setView(R.layout.add_student)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
                                String name = ((EditText)dialogView.findViewById(R.id.txtName)).getText().toString();
                                String major = ((EditText)dialogView.findViewById(R.id.txtMajor)).getText().toString();
                                String phoneNumber = ((EditText)dialogView.findViewById(R.id.txtPhoneNumber)).getText().toString();
                                String qq = ((EditText)dialogView.findViewById(R.id.txtQQ)).getText().toString();

                                Student student = new Student(name,major,phoneNumber,qq);
                                students.add(student);
                                initData();


                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();


                break;
            case R.id.btnDelete:
                final int childCount = lvStudents.getChildCount();
                if (childCount==0) return;

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(R.string.confirm)
                        .setMessage(getString(R.string.are_you_sure_to_delete))
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Toast.makeText(MainActivity.this, String.valueOf(childCount), Toast.LENGTH_SHORT).show();
                                for (int index = childCount - 1; index >= 0;index--){
                                    View itemView = lvStudents.getChildAt(index);
                                    CheckBox chkChecked = (CheckBox) itemView.findViewById(R.id.chkChecked);
                                    if(chkChecked.isChecked()){
                                        students.remove(index);
                                    }
                                }

                                initData();
                            }
                        })
                        .setNegativeButton(R.string.cancel,null)
                        .show();

                break;
        }
    }
}
