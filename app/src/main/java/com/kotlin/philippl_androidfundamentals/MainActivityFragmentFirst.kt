package com.kotlin.philippl_androidfundamentals

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kotlin.philippl_androidfundamentals.activity.*
import com.kotlin.philippl_androidfundamentals.databinding.ActivityMainFragment1Binding
import java.util.*

class MainActivityFragmentFirst : Fragment() {

    private var _binding: ActivityMainFragment1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityMainFragment1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnActvImage.setOnClickListener {
            Intent(activity, ImageActivity::class.java).apply {
                startActivity(this)
            }
        }

        binding.btnCkboxRdio.setOnClickListener {
            Intent(activity, CheckboxRadioActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnToasts.setOnClickListener {
            startActivity(Intent(activity, ToastsActivity::class.java))
        }

        binding.btnForm.setOnClickListener {
            startActivity(Intent(activity, FormActivity::class.java))
        }

        binding.btnRequestPermission.setOnClickListener {
//            requestPermissions()
//            val appPermission = arrayOf(
//                Manifest.permission.CAMERA
////                Manifest.permission.ACCESS_COARSE_LOCATION,
////                Manifest.permission.ACCESS_BACKGROUND_LOCATION,
//            )
//            requestPermissions(appPermission, 0)
//            if (Manifest.permission.CAMERA == PackageManager.PERMISSION_GRANTED)
//            activityResultLauncher.launch(appPermission)
        }

        binding.btnImplicitIntents.setOnClickListener {
            startActivity(Intent(activity, ImplicitIntentsActivity::class.java))
        }

        binding.btnToolbarMenu.setOnClickListener {
            startActivity(Intent(activity, ToolbarMenuActivity::class.java))
        }

        binding.btnAlertDialog.setOnClickListener {
            startActivity(Intent(activity, AlertDialogActivity::class.java))
        }

        binding.btnInflaterActivity.setOnClickListener {
            startActivity(Intent(activity, InflaterActivity::class.java))
        }

        binding.btnSpinner.setOnClickListener {
            Intent(activity, SpinnerActivity::class.java).apply {
                startActivity(this)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}