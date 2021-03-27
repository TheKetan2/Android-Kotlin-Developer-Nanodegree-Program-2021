/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.guesstheword.screens.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.android.guesstheword.R
import com.example.android.guesstheword.databinding.GameFragmentBinding
import kotlinx.android.synthetic.main.score_fragment.*

/**
 * Fragment where the game is played
 */
class GameFragment : Fragment() {

    private lateinit var viewModal: GameViewModal
    // The current word


    private lateinit var binding: GameFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.game_fragment,
                container,
                false
        )

        Log.i("GameFragment", "Game Fragment Created!" )
        viewModal = ViewModelProvider(this).get(GameViewModal::class.java)


        binding.correctButton.setOnClickListener {
            viewModal.onCorrect()
        }
        binding.skipButton.setOnClickListener {
            viewModal.onSkip()
        }

        viewModal.score.observe(viewLifecycleOwner, Observer { newScore ->
            binding.scoreText.text = newScore.toString()
        })

        viewModal.word.observe(viewLifecycleOwner, Observer { newWord ->
            binding.wordText.text = newWord.toString()
        })
        return binding.root

    }

    private fun gameFinished(){
        val action = GameFragmentDirections.actionGameToScore()
        action.setScore(viewModal.score.value?:0)
        findNavController().navigate(action)
    }


    /** Methods for updating the UI **/

//    private fun updateWordText() {
//        binding.wordText.text = viewModal.word.value?:""
//    }

//    private fun updateScoreText() {
//        binding.scoreText.text = viewModal.score.toString()
//    }
}
