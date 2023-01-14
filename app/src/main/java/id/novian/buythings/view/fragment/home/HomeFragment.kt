package id.novian.buythings.view.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import id.novian.buythings.databinding.FragmentHomeBinding

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryClicked()
    }

    private fun categoryClicked() {
        val cardListener = View.OnClickListener { p0 -> viewModel.cardClicked(p0!!) }

        binding.apply {
            cvElectronic.setOnClickListener(cardListener)
            cvJewelery.setOnClickListener(cardListener)
            cvMen.setOnClickListener(cardListener)
            cvWomen.setOnClickListener(cardListener)
        }
    }

}