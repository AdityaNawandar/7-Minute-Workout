package com.example.a7minuteworkout

class Exercises {
    companion object {
        fun defaultExerciseList(): ArrayList<ExerciseModel> {

            val exerciseList = ArrayList<ExerciseModel>()

            val jumpingJacks = ExerciseModel(
                1,
                "Jumping Jacks",
                R.drawable.ic_jumping_jacks,
                false,
                false
            )
            exerciseList.add(jumpingJacks)

            val wallSits = ExerciseModel(
                2,
                "Wall-Sits",
                R.drawable.ic_wall_sit,
                false,
                false
            )
            exerciseList.add(wallSits)

            val pushUps = ExerciseModel(
                3,
                "Push-ups",
                R.drawable.ic_push_up,
                false,
                false
            )
            exerciseList.add(pushUps)

            val crunches = ExerciseModel(
                4,
                "Crunches",
                R.drawable.ic_abdominal_crunch,
                false,
                false
            )
            exerciseList.add(crunches)

            val stepUpOnChair = ExerciseModel(
                5,
                "Step-up on chair",
                R.drawable.ic_step_up_onto_chair,
                false,
                false
            )
            exerciseList.add(stepUpOnChair)

            val squats = ExerciseModel(
                6,
                "Squats",
                R.drawable.ic_squat,
                false,
                false
            )
            exerciseList.add(squats)

            val tricepDipsOnChair = ExerciseModel(
                7,
                "Tricep dips on chair",
                R.drawable.ic_triceps_dip_on_chair,
                false,
                false
            )
            exerciseList.add(tricepDipsOnChair)

            val planks = ExerciseModel(
                8,
                "Planks",
                R.drawable.ic_plank,
                false,
                false
            )
            exerciseList.add(planks)

            val highKnees = ExerciseModel(
                9,
                "High Knees",
                R.drawable.ic_high_knees_running_in_place,
                false,
                false
            )
            exerciseList.add(highKnees)

            val lunges = ExerciseModel(
                10,
                "Lunges",
                R.drawable.ic_lunge,
                false,
                false
            )
            exerciseList.add(lunges)

            val pushUpAndRotation = ExerciseModel(
                11,
                "Push-up and rotation",
                R.drawable.ic_push_up_and_rotation,
                false,
                false
            )
            exerciseList.add(pushUpAndRotation)

            val sidePlanks = ExerciseModel(
                12,
                "Side Planks",
                R.drawable.ic_side_plank,
                false,
                false
            )
            exerciseList.add(sidePlanks)

            return exerciseList
        }
    }
}