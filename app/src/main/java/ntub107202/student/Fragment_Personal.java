package ntub107202.student;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment_Personal extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_personal,container,false);
        Button button00 = (Button)view.findViewById(R.id.btn_edit_resume);
        Button button01 = (Button)view.findViewById(R.id.btn_hire_history);
        Button button02 = (Button)view.findViewById(R.id.btn_contact_history);
        Button btn_collection = (Button)view.findViewById(R.id.btn_collection);
        Button button03 = (Button)view.findViewById(R.id.btn_return);
        Button button04 = (Button)view.findViewById(R.id.btn_about);
        Button button05 = (Button)view.findViewById(R.id.btn_specification);
        Button button06 = (Button) view.findViewById(R.id.btn_notice);
        Button button07 = (Button)view.findViewById(R.id.btn_login);
        Button button08 = (Button)view.findViewById(R.id.btn_reg);
        button00.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Personal_resume.class);
                startActivity(intent);
            }
        });
        button01.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Personal_Hirehistory.class);
                startActivity(intent);
            }
        });
        button02.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Personal_Contacthistory.class);
                startActivity(intent);
            }
        });
        btn_collection.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Personal_Collection.class);
                startActivity(intent);
            }
        });
        button03.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Personal_Returnproblem.class);
                startActivity(intent);
            }
        });
        button04.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Personal_Aboutme.class);
                startActivity(intent);
            }
        });
        button05.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Personal_Specification.class);
                startActivity(intent);
            }
        });
        button06.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Personal_Notification.class);
                startActivity(intent);
            }
        });

        button07.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Login.class);
                startActivity(intent);
            }
        });
        button08.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Register.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
