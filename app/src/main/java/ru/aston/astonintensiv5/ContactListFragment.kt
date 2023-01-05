package ru.aston.astonintensiv5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.aston.astonintensiv5.adapter.ContactListAdapter
import ru.aston.astonintensiv5.adapter.Contacts
import ru.aston.astonintensiv5.databinding.FragmentContactListBinding

private const val TAG = "CONTACT_LIST_FRAGMENT"

class ContactListFragment : Fragment() {

    var onContactClicked: (Contacts) -> Unit = {}
    private lateinit var adapter: ContactListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = ContactListAdapter(onContactClicked)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = List(100) { index ->
            Contacts(
                id = index,
                name = "Alexey",
                secondName = "Popov",
                phoneNumber = "8999343557$index",
                pictureUri = "https://picsum.photos/id/${1 + index}/200"
            )
        }
        submitData(list)
    }

    private fun submitData(contacts: List<Contacts>) {
        adapter.submitList(contacts)
    }

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentContactListBinding.inflate(inflater)
        binding.contactlistRecyclerview.adapter = adapter
//        val contact = ContactFragment()
//        binding.root.setOnClickListener {
//            childFragmentManager.beginTransaction()
//                .add(R.id.contact_list, contact)
//                .addToBackStack(TAG)
//                .commit()
//        }

        return binding.root
    }

}