package com.sudoajay.picsum.main.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sudoajay.picsum.R
import com.sudoajay.picsum.databinding.LayoutSettingBottomSheetBinding
import com.sudoajay.picsum.main.MainActivity
import com.sudoajay.picsum.main.proto.ProtoManager
import kotlinx.coroutines.launch
import javax.inject.Inject


class SettingBottomSheet @Inject constructor
    () : BottomSheetDialogFragment() {
    @Inject
    lateinit var protoManager: ProtoManager
    lateinit var mainActivity: MainActivity


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        val myDrawerView = layoutInflater.inflate(R.layout.layout_setting_bottom_sheet, container, false)
        val binding = LayoutSettingBottomSheetBinding.inflate(
            layoutInflater,
            myDrawerView as ViewGroup,
            false
        )


        binding.bottomSheet = this
        binding.activity = mainActivity
        binding.lifecycleOwner = this

        return binding.root
    }


    fun setJsonValue(json: String) {
        lifecycleScope.launch {
            protoManager.setJsonConverter(json)
        }
        dismiss()
    }

    fun setDataBaseValue(database: String) {
        lifecycleScope.launch {
            protoManager.setDataBase(database)
        }
        dismiss()
    }
    fun setImageLoader(imageLoader: String) {
        lifecycleScope.launch {
            protoManager.setImageLoader(imageLoader)
        }
        dismiss()
    }


}