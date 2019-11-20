package com.example.mdm_everis.home.profile

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.core.Constant
import com.example.domain.user.UserResponse
import com.example.mdm_everis.MainActivity
import com.example.mdm_everis.R
import com.example.mdm_everis.base.BaseFragment
import kotlinx.android.synthetic.main.profile_data_card_view.*
import kotlinx.android.synthetic.main.profile_fragment.*


class ProfileFragment : BaseFragment<ProfileViewModel>() {

    //******************************************* BaseFragment abstract ****************************

    override fun getLayout() = R.layout.profile_fragment
    override fun getViewModel() = ProfileViewModel::class

    //******************************************* End BaseFragment abstract ************************

    var userData : UserResponse? = null
    private val args : ProfileFragmentArgs by navArgs()
    lateinit var userId : String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        baseNavBar.menu.getItem(3).isChecked = true
        userId = args.userId
        setData()
        initObserves()
        initListener()
    }

    //******************************************* Init *********************************************
    private fun initListener(){
        viewModel.fragmentFlag = Constant.FragmentFlag.PROFILE
        profile_refresh.setOnRefreshListener {
            profile_refresh.isRefreshing = false
            viewModel.getUserById(userId)
        }
    }
    private fun initObserves(){
        viewModel.getUserByIdLD.observe(this,getUserByIdObserver)
    }

    //******************************************* End Init *****************************************

    //******************************************* Observers ****************************************
    private  val getUserByIdObserver = Observer<UserResponse>{
        it?.let {
            (activity as MainActivity).setUser(it)
        } ?: run{
            toast("Se ha habido un error al obtener el usuario")
        }
        setData()
    }
    //******************************************* End Observers ************************************

    private fun setData(){
        userData = (activity as MainActivity).getUser()
        tv_name_content.text = userData?.name
        tv_email_content.text = userData?.email
    }

}
