import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.bottomsheettest.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetDialog(context: Context) : BottomSheetDialogFragment()
{
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_bottom_sheet_dialog, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        view?.findViewById<Button>(R.id.button_bottom_sheet)?.setOnClickListener {
            Toast.makeText(context, "Bottom Sheet 안의 버튼 클릭", Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }
}