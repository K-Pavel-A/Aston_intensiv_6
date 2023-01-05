package ru.aston.astonintensiv5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.aston.astonintensiv5.databinding.ContactBinding

private const val TAG = "CONTACT_LIST_FRAGMENT"

class ContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = ContactBinding.inflate(inflater)

        return binding.root

    }


}