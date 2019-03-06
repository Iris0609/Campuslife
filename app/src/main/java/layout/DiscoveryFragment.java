package layout;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.jc.campuslife.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DiscoveryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DiscoveryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DiscoveryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private Spinner spinner;
    private ArrayAdapter adapter;


    public DiscoveryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DiscoveryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DiscoveryFragment newInstance(String param1, String param2) {
        DiscoveryFragment fragment = new DiscoveryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View discoveryLayout=inflater.inflate(R.layout.discovery_layout,container,false);
        spinner=(Spinner)discoveryLayout.findViewById(R.id.spinner1);
        //可选内容与ArrayAdapter连接起来
        adapter=ArrayAdapter.createFromResource(getActivity().getApplicationContext(),R.array.time_dis,android.R.layout.simple_spinner_dropdown_item);
        //设置下拉列表的风格
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将adapter添加到spinner中
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new SpinnerXMLSelectedListener());

        //设置默认值
        spinner.setVisibility(View.VISIBLE);
        return discoveryLayout;

    }

    /*onItemSelected参数
    第一个参数parent是你当前所操作的Spinner，当某一个Activity中有多个Spinner时，可以根据parent.getId()与R.id.currentSpinner是否相等，来判断是否你当前操作的Spinner，
    一般在onItemSelected方法中，通过switch...case...语句来解决多个Spinner的情况
    第二个参数view,经过我的测试，在同一个Activity的多个Spinner中，无论你操作任何一个Spinner，选中任何一个下拉值，view(或者说view.getId())的值都不变，因此，我们可以不用关心这个view，因为一般不可能用得到。
    第三个参数position，是你选中的某个Spinner中的某个下拉值所在的位置，一般自上而下从0开始。
    第四个参数id，是你选中的某个Spinner中的某个下来值所在的行，一般自上而下从0开始，id的值与第三个参数position的值一直是一样的。
     */
    class SpinnerXMLSelectedListener implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                   long arg3) {

            /*
            添加选择不同选项的行为可以用arg2结合switch...case..语句
             */
        }
        public void onNothingSelected(AdapterView<?> arg0) {
            /*
            默认排序
             */
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
