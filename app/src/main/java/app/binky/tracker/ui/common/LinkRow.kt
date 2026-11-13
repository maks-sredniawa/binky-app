package app.binky.tracker.ui.common

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import app.binky.tracker.R

/** Where a [LinkRow] goes, which decides its trailing icon. */
enum class LinkTarget {
    /** Another screen of this app: a chevron. */
    Inside,

    /** Another app or a system screen: "open in new". */
    Outside,

    /** Nowhere: an action done on this screen. No icon. */
    Here,
}

/** android-starter's shared rows draw through this; in Binky it is a [ListRow] with the target's icon. */
@Composable
fun LinkRow(
    title: String,
    target: LinkTarget,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
) {
    ListRow(
        title = title,
        modifier = modifier,
        subtitle = subtitle,
        onClick = onClick,
        trailing =
            when (target) {
                LinkTarget.Inside -> {
                    { Chevron() }
                }
                LinkTarget.Outside -> {
                    {
                        Icon(
                            painter = painterResource(R.drawable.ic_open_in_new),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    }
                }
                LinkTarget.Here -> null
            },
    )
}
